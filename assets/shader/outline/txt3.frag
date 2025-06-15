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

    // 用环形采样方式检测边缘
    float minDist = u_thickness + 1.0;

    for (float radius = 0.0; radius <= u_thickness; radius++) {
        float stepAngle = 3.14159 * 2.0 / 8.0; // 8 个方向采样
        for (float angle = 0.0; angle < 6.3; angle += stepAngle) {
            vec2 offset = vec2(cos(angle), sin(angle)) * radius * u_texelSize;
            float sampleAlpha = texture2D(u_texture, v_textCoords + offset).a;
            if (sampleAlpha > 0.0) {
                minDist = min(minDist, radius);
            }
        }
    }

    if (minDist <= u_thickness) {
        // 距离越小 → alpha 越大（渐变效果）
        float alpha = (1.0 - minDist / u_thickness) * 2;
        gl_FragColor = vec4(u_outlineColor.rgb, alpha);
    } else {
        discard;
    }
}
