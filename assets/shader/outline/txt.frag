#ifdef GL_ES
precision mediump float;
#endif

uniform sampler2D u_texture;
uniform vec2 u_texelSize;
uniform vec4 u_outlineColor;
uniform float u_thickness; // 半径：渐变范围

varying vec2 v_textCoords;

void main() {
    float centerAlpha = texture2D(u_texture, v_textCoords).a;

    if (centerAlpha > 0.0) {
        gl_FragColor = texture2D(u_texture, v_textCoords); // 原图部分
        return;
    }

    float totalWeight = 0.0;
    float outlineWeight = 0.0;

    for (float x = -u_thickness; x <= u_thickness; x++) {
        for (float y = -u_thickness; y <= u_thickness; y++) {
            vec2 offset = vec2(x, y);
            float dist = length(offset);
            if (dist <= u_thickness) {
                float weight = 1.0 - dist / u_thickness;
                vec2 sampleUV = v_textCoords + offset * u_texelSize;
                float alpha = texture2D(u_texture, sampleUV).a;
                outlineWeight += alpha * weight;
                totalWeight += weight;
            }
        }
    }

    float finalAlpha = clamp(outlineWeight / totalWeight, 0.0, 1.0) * u_outlineColor.a;

    if (finalAlpha > 0.00) {
        gl_FragColor = vec4(u_outlineColor.rgb, finalAlpha);
    } else {
        discard;
    }
}
