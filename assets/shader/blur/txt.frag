#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;


uniform vec2 resolution;
uniform float blurRadius;
uniform float sampleNum;

vec4 blur(vec2);

void main() {
    vec4 textureColor = v_color* blur(v_textCoords);
    gl_FragColor = textureColor;
}


vec4 blur(vec2 p){
    if (blurRadius > 0.0 && sampleNum > 1.0){
        vec4 col = vec4(0);
        vec2 unit = 1.0 / resolution.xy;
        float r = blurRadius;
        float sampleStep = r / sampleNum;
        float count = 0.0;
        for(float x = -r; x < r; x += sampleStep){
            for(float y = -r; y < r; y += sampleStep){
                float weight = (r - abs(x)) * (r - abs(y));
                col += texture2D(u_texture, p + vec2(x * unit.x, y * unit.y)) * weight;
                count += weight;
            }
        }
        return col / count;
    }

    return texture2D(u_texture, p);
}