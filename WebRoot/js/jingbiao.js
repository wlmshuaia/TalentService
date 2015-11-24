// JavaScript Document

b=function()
{
	var jingbiao=document.getElementById("jingbiao");
	var jingbiaofangan=document.getElementById("jingbiaofangan");
	var guanbi=document.getElementById("guanbi");
	
	jingbiao.onmouseover=function()
	{
		this.style.cursor="pointer";
		jingbiao.style.background="#FFF";
		jingbiao.style.color="#ff6900";
		
		
	}
	
	jingbiao.onmouseout=function()
	{
		jingbiao.style.background="#ff6900";
		jingbiao.style.color="#FFF";
	}
	
	
	document.body.onmousewheel=function()
	{
		if(jingbiaofangan.style.display=="block")
		{return false;}
		else
		{return true;}
	}
	jingbiao.onclick=function()
	{
		
		if(jingbiaofangan.style.display=="none")
		{
			jingbiaofangan.style.display="block";
			document.body.style.overflow="hidden";
			

			
			
			
		}
		
	}
	guanbi.onclick=function()
	{
		jingbiaofangan.style.display="none";
		
		document.body.style.overflow="auto";
	}
	guanbi.onmouseover=function()
	{
		this.style.cursor="pointer";
	}
	
	
	
	
	
	
	
	
	
	
}
