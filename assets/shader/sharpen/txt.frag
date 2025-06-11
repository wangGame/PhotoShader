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




    vec4 textureColor = v_color* texture2D(u_texture,v_textCoords);
    gl_FragColor = vec4((textureColor.rgb + vec3(brightness,brightness,brightness)),textureColor.w);
}


 "precision highp float;\n" +
            "\n" +
            "varying highp vec2 textureCoordinate;\n" +
            "varying highp vec2 leftTextureCoordinate;\n" +
            "varying highp vec2 rightTextureCoordinate; \n" +
            "varying highp vec2 topTextureCoordinate;\n" +
            "varying highp vec2 bottomTextureCoordinate;\n" +
            "\n" +
            "varying highp float centerMultiplier;\n" +
            "varying highp float edgeMultiplier;\n" +
            "\n" +
            "uniform sampler2D inputImageTexture;\n" +
            "\n" +
            "void main()\n" +
            "{\n" +
            "    mediump vec3 textureColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n" +
            "    mediump vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb;\n" +
            "    mediump vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb;\n" +
            "    mediump vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb;\n" +
            "    mediump vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb;\n" +
            "\n" +
            "    gl_FragColor = vec4((textureColor * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)), texture2D(inputImageTexture, bottomTextureCoordinate).w);\n" +
            "}";