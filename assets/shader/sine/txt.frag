#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;


float sineWave(float x) {
    return 0.5 + 0.4 * sin(x * 48.14159);
}

void main() {
    float sineY = sineWave(v_textCoords.x);
    float distance = abs(v_textCoords.y - sineY);
    float fade = smoothstep(0.004, 0.001, distance);


    vec4 textureColor = v_color * texture2D(u_texture, v_textCoords);
    textureColor = mix(textureColor, vec4(1.0, 1.0, 1.0, 1.0), fade);

    gl_FragColor = textureColor;
}