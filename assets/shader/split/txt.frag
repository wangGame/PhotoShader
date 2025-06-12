#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

uniform float splitX;
uniform float splitY;

void main() {
    float scaleX = 1.0 / splitX;
    float scaleY = 1.0 / splitY;
    vec2 tempTextCoords = vec2(v_textCoords.x, v_textCoords.y);
    tempTextCoords.x = mod(v_textCoords.x, scaleX) * splitX;
    tempTextCoords.y = mod(v_textCoords.y, scaleY) * splitY;
    vec4 textureColor = v_color * texture2D(u_texture, tempTextCoords);
    gl_FragColor = textureColor;
}