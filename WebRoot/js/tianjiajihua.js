// JavaScript Document
function p()
{
	var tianjiajihua=document.getElementById("tianjiajihua");
	var tianjiajihua1=document.getElementById("tianjiajihua1");
	var querentianjia=document.getElementById("querentianjia");
	var chakan=document.getElementById("chakan");
	
	chakan.style.cursor="pointer";
	
	chakan.onmouseover=function()
	{
		this.style.background="#ff6900";
		this.style.color="#fff";
	}
	
	chakan.onmouseout=function()
	{
		this.style.color="#b6b6b6";
		this.style.background="#efeef4";
	}
	tianjiajihua.style.cursor="pointer";
	tianjiajihua.onclick=function()
	{
		if(tianjiajihua1.style.display=="none")
		{tianjiajihua1.style.display="block";
			this.innerHTML="收起计划";
		
		}
		else
		{tianjiajihua1.style.display="none";
			this.innerHTML="添加计划";		
		}
		
	}
	
	querentianjia.style.cursor="pointer";
	
	
	
	
	
	
		
}
