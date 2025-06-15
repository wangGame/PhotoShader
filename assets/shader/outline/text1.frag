#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float brightness;

uniform vec2 u_texelSize;
uniform vec4 u_outlineColor;
uniform float u_thickness;

void main() {

    float alpha = texture2D(u_texture, v_textCoords).a;
    float maxAlpha = 0.0;
    float x = 0;
    float y = 0;

    for (x = -u_thickness; x <= u_thickness; x++) {
        for ( y = -u_thickness; y <= u_thickness; y++) {
            vec2 offset = vec2(x, y) * u_texelSize;
            maxAlpha = max(maxAlpha, texture2D(u_texture, v_textCoords + offset).a);
        }
    }
/*
    if (alpha == 0.0 && maxAlpha > 0.0) {
        gl_FragColor = u_outlineColor;
    } else {
       vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
        gl_FragColor = textureColor;
    }
*/