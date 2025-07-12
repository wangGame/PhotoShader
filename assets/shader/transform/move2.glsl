#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform sampler2D u_texture1;
uniform float time;
void main() {
    vec2 uv = v_textCoords;
    if(uv.x>0.5){
        uv.y = uv.y+time;
        if(uv.y>1){
            uv.y-=1.0;
            vec4 rgb = texture2D(u_texture, uv);
            gl_FragColor = rgb;
        }else{
            vec4 rgb = texture2D(u_texture1, uv);
            gl_FragColor = rgb;
        }
    }else{
        uv.y = uv.y-time;

        if(uv.y<0){
            uv.y+=1.0;
            vec4 rgb1 = texture2D(u_texture, uv);
            gl_FragColor = rgb1;
        }else{
            vec4 rgb = texture2D(u_texture1, uv);
            gl_FragColor = rgb;
        }

    }
}