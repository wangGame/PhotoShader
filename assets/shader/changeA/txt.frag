#ifdef GL_ES
precision mediump float;
#endif


varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

void main() {
    vec2 v_ballPosition = v_textCoords;
    vec4 textureColor = v_color* texture2D(u_texture,v_ballPosition);
    gl_FragColor = textureColor;
}
