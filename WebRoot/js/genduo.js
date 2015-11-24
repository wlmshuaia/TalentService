// JavaScript Document

function d()
{
	var z=document.getElementById("genduo");
	var h=document.getElementById("zhankai");
	z.onclick=function()
	{
		if(h.style.display=="none")
		{
			h.style.display="block";
			z.style.background="url(./images/shouqi.gif)";
		}
		else
		{
			h.style.display="none";
			z.style.background="url(./images/zhankai.gif)";
		}
		
	}
	
	z.onmouseover=function()
	{
		this.style.cursor="pointer";	
	}
}