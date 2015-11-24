// JavaScript Document

function tj()
{
	var tijiao=document.getElementById("tijiao");
	var kuang=document.getElementById("kuang");
	var ping=document.getElementById("ping");

	tijiao.onmouseover=function()
	{
		this.style.cursor="pointer";
	}
		
	tijiao.onclick=function()
	{	if(kuang.value!=""){
		ping.innerHTML+='<li><div style="background:url(../images/touxiang.gif); width:90px; height:105px; float:left"></div><div style="float:left; width:820px; hanging-punctuation:105px; margin-left:20px;"><div style="height:40px;color:#233c52; font-size:20px; line-height:2em">用户名</div><div style="height:30px;">'+kuang.value+'</div><div style="height:33px; font-size:16px;">时间</div></div></li>';}
	}
	
	
}