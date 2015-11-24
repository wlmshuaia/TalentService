// JavaScript Document
function g()
{
	var genduo=document.getElementById("genduo");
	var zhankai=document.getElementById("zhankai");
	
	genduo.onclick=function()
	{
		if(zhankai.style.display=="none")
		{
			this.style.background="#efeef4";
			this.style.color="#cfced2";
			zhankai.style.display="block";
		}
		else
		{
			this.style.background="#ff6900";
			this.style.color="#fff";
			zhankai.style.display="none";
			
		}
	}
	
	
	
	
}