#ifdef GL_ES
precision mediump float;
#endif


varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;



void main() {
    int type1 = 0;
    int type2 = 0;
    if(v_textCoords.x<=0.5){
        type1 = 0;
        v_textCoords.x = v_textCoords.x * 2.0;
    }else{
        type1 = 1;
        v_textCoords.x = v_textCoords.x * 2.0 - 1.0f;
    }

    if(v_textCoords.y<=0.5){
        type2 = 2;
        v_textCoords.y = v_textCoords.y * 2.0;
    }else{
        type2 = 3;
        v_textCoords.y = v_textCoords.y * 2.0 - 1.0f;
    }
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    if(type1 == 0 && type2 == 2){
        textureColor.r = 1;
    }else if(type1 == 1 && type2 == 2){
        textureColor.g = 1;
    }else if(type1 == 0 && type2 == 3){
        textureColor.b = 1;
    }else if(type1 == 1 && type2 == 3){
        float v = (textureColor.r + textureColor.g + textureColor.b) / 3.0;
        textureColor.r = v;
        textureColor.g = v;
        textureColor.b = v;
    }
    gl_FragColor = textureColor;
}
