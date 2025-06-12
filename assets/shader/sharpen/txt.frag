#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

uniform float sharpness;
uniform float imageWidthFactor;
uniform float imageHeightFactor;

void main() {
    float centerMultiplier = 1.0 + 4.0 * sharpness;
    float edgeMultiplier = sharpness;

   vec2 left = vec2(v_textCoords.x-imageWidthFactor,v_textCoords.y);
   vec2 right = vec2(v_textCoords.x+imageWidthFactor,v_textCoords.y);
   vec2 top = vec2(v_textCoords.x,v_textCoords.y-imageHeightFactor);
   vec2 bottom = vec2(v_textCoords.x,v_textCoords.y-imageHeightFactor);

    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    vec4 textureLeftColor = v_color* texture2D(u_texture,left);
    vec4 textureRightColor = v_color* texture2D(u_texture,right);
    vec4 textureTopColor = v_color* texture2D(u_texture,top);
    vec4 textureBottomColor = v_color* texture2D(u_texture,bottom);

    gl_FragColor =
        vec4(
            (textureColor * centerMultiplier
                - (textureLeftColor * edgeMultiplier
                + textureRightColor * edgeMultiplier
                + textureTopColor * edgeMultiplier
                + textureBottomColor * edgeMultiplier)));
}


