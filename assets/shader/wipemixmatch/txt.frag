#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform float time;
uniform float u;
uniform float v;
uniform float u1;
uniform float v1;


void main() {
    vec4 sourceColor = texture2D(u_texture, v_textCoords) * v_color;
    vec4 sourceColor2 = texture2D(u_texture1, v_textCoords) * v_color;
    gl_FragColor = vec4(mix(sourceColor.rgb,sourceColor2.rgb,time),sourceColor.a);
}
