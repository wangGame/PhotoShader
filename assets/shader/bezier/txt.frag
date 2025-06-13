#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float brightness;

vec2 cubicBezier(vec2 t, vec2 p0, vec2 p1, vec2 p2, vec2 p3) {
    vec2 u = 1.0 - t;
    vec2 tt = t * t;
    vec2 uu = u * u;
    vec2 uuu = uu * u;
    vec2 ttt = tt * t;

    vec2 p = uuu * p0;
    p += 3.0 * uu * t * p1;
    p += 3.0 * u * tt * p2;
    p += ttt * p3;

    return p;
}

void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    gl_FragColor = vec4((textureColor.rgb + vec3(brightness,brightness,brightness)),textureColor.w);
}