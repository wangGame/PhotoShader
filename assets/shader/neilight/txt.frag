#ifdef GL_ES
precision mediump float;
#endif

varying vec4 v_color;
varying vec2 v_textCoords;
uniform sampler2D u_texture;
uniform float brightness;
int glowColorSize = 51 ;

float getColorAlpha(float angle,float dist){
    float radian = radians(angle);
    vec4 color = texture2D(u_texture, v_textCoords + vec2(dist * cos(radian), dist * sin(radian)));
    return color.a;
}

float getAverageAlpha(float dist) {

    float totalAlpha = 0.0;
    totalAlpha += getColorAlpha(0.0, dist);
    totalAlpha += getColorAlpha(30.0, dist);
    totalAlpha += getColorAlpha(60.0, dist);
    totalAlpha += getColorAlpha(90.0, dist);
    totalAlpha += getColorAlpha(120.0, dist);
    totalAlpha += getColorAlpha(150.0, dist);
    totalAlpha += getColorAlpha(180.0, dist);
    totalAlpha += getColorAlpha(210.0, dist);
    totalAlpha += getColorAlpha(240.0, dist);
    totalAlpha += getColorAlpha(270.0, dist);
    totalAlpha += getColorAlpha(300.0, dist);
    totalAlpha += getColorAlpha(330.0, dist);
    return totalAlpha * 0.05;
}

float getGlowAlpha() {

    float totalAlpha = 0.0;
    totalAlpha += getAverageAlpha(glowColorSize * 0.1);
    totalAlpha += getAverageAlpha(glowColorSize * 0.2);
    totalAlpha += getAverageAlpha(glowColorSize * 0.3);
    totalAlpha += getAverageAlpha(glowColorSize * 0.4);
    totalAlpha += getAverageAlpha(glowColorSize * 0.5);
    totalAlpha += getAverageAlpha(glowColorSize * 0.6);
    totalAlpha += getAverageAlpha(glowColorSize * 0.7);
    totalAlpha += getAverageAlpha(glowColorSize * 0.8);
    totalAlpha += getAverageAlpha(glowColorSize * 0.9);
    totalAlpha += getAverageAlpha(glowColorSize * 1.0);
    return totalAlpha * 0.05;
}

void main() {
    float alpha = 1.0- getGlowAlpha();
    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    gl_FragColor = vec4(1.0,0.0,0.0,0.0);
    gl_FragColor.a =textureColor.a * alpha;
}