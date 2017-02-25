uniform vec3 _WorldSpaceCameraPos;
varying mediump vec2 uv;
uniform mediump sampler2D _MainTex;
uniform mediump vec4 _fogColor;
uniform mediump float _fogStart;
uniform mediump float _fogEnd;
varying mediump vec4 vertexColor;
varying mediump vec4 worldSpaceCoord;

void main(){
    vec4 tex = tex2D (_MainTex, uv );
    gl_FragColor = vec4(mix(tex.rgb, _fogColor.rgb, vertexColor.r), 1.0);
} 