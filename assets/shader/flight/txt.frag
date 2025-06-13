#ifdef GL_ES
precision mediump float;
#endif
varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;

void main() {
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    if(v_textCoords.x>0.8){
         float a = 1.0 - (v_textCoords.x - 0.8)  / 0.2;
         textureColor = vec4(1.0,1.0,0,1.0);
         textureColor.a = a;
    }else if(v_textCoords.x<0.2){
        float a = 1.0 - (0.2 - v_textCoords.x)  / 0.2;
         textureColor = vec4(1.0,1.0,0,1.0);
         textureColor.a = a;
    }else if(v_textCoords.y<0.2){
         float a = 1.0 - (0.2 - v_textCoords.y)  / 0.2;
         textureColor = vec4(1.0,1.0,0,1.0);
         textureColor.a = a;
    }else if(v_textCoords.y>0.8){
          float a = 1.0 - (v_textCoords.y - 0.8)  / 0.2;
          textureColor = vec4(1.0,1.0,0,1.0);
          textureColor.a = a;
     }
    gl_FragColor = textureColor;
}