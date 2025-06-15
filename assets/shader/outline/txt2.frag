#ifdef GL_ES
precision mediump float;
#endif

uniform sampler2D u_texture;
uniform vec2 u_texelSize;
uniform vec4 u_outlineColor;
uniform float u_thickness;

varying vec2 v_textCoords;

void main() {
    float centerAlpha = texture2D(u_texture, v_textCoords).a;

    if (centerAlpha > 0.0) {

        gl_FragColor = texture2D(u_texture, v_textCoords);
        return;
    }

    // 降采样只采样 8 个方向，记录最小近似距离
    float minDist = u_thickness + 1.0;
    float maxAlpha = 0.0;

    vec2 offsets[8];
    offsets[0] = vec2(-1, 0);
    offsets[1] = vec2(1, 0);
    offsets[2] = vec2(0, -1);
    offsets[3] = vec2(0, 1);
    offsets[4] = vec2(-1, -1);
    offsets[5] = vec2(1, -1);
    offsets[6] = vec2(-1, 1);
    offsets[7] = vec2(1, 1);

    for (int i = 0; i < 8; i++) {
        vec2 offset = offsets[i] * u_texelSize * u_thickness;
        float sampleAlpha = texture2D(u_texture, v_textCoords + offset).a;

        if (sampleAlpha > 0.0) {
            float approxDist = abs(offset.x) + abs(offset.y); // 替代 sqrt()
            minDist = min(minDist, approxDist);
            maxAlpha = max(maxAlpha, sampleAlpha);
        }
    }

    if (maxAlpha > 0.0) {
        float fade =1.0 - clamp(minDist / (u_texelSize.x * u_thickness * 3.0), 0.0, 1.0);
        gl_FragColor = vec4(u_outlineColor.rgb, fade);
    } else {

        gl_FragColor = texture2D(u_texture, v_textCoords);
    }
}