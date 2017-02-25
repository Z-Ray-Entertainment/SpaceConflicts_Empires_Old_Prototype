uniform vec3 _WorldSpaceCameraPos;
varying mediump vec2 uv;
uniform mediump sampler2D _MainTex;
uniform mediump vec4 _fogColor;
uniform mediump float _fogStart;
uniform mediump float _fogEnd;
varying mediump vec4 vertexColor;
varying mediump vec4 worldSpaceCoord;

void main(){
    gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
    uv = gl_MultiTexCoord0.xy;
    worldSpaceCoord = gl_ModelViewMatrix * gl_Vertex;
    float distToCamera = abs(worldSpaceCoord.z - _WorldSpaceCameraPos.z - _fogStart);
    float ratio = distToCamera / _fogEnd;
    vertexColor = gl_Color;
    vertexColor.r = min(ratio, 1);
}