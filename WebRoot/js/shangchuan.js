// JavaScript Document

function s()
{
	var shangchuan=document.getElementById("shangchuan");
	
	var fg=[];
	var gh=[];
	var shanchu=document.getElementById("shanchu");
	
	
	
	

	
	
	shangchuan.onmouseover=function()
	{
		this.style.cursor="pointer";
		
	}
	
	shangchuan.onclick=function()
	{
		var kk=document.createElement("div");
		kk.style.height=25+"px";
		
		var kkk=document.createElement("input");
		kkk.type="file";
		kkk.name = "upload" ; 
		kkk.style.cssFloat="left";
		
		var kkkk=document.createElement("span");
		kkkk.style.display="inline-block";
		kkkk.style.height=24+"px";
		kkkk.style.width=50+"px";
		kkkk.style.marginLeft=20+"px";
		kkkk.style.fontSize=16+"px";
		kkkk.style.cssFloat="left";
		kkkk.innerHTML="删除";
		
		kk.appendChild(kkk);
		kk.appendChild(kkkk);		
		
		fg.push(kkkk);	
		
		shanchu.appendChild(kk);
		
		gh.push(kk);
		
		
		
		h();	
	}
	
	function h()
	{
		
		
		
		
		
		for(var i=0;i<fg.length;i++)
		{
			
			
			fg[i].onmouseover=function()
			{
				this.style.cursor="pointer";
				
				
			}
			
			
			fg[i].onclick=function()
			{
				
				
				shanchu.removeChild(this.parentNode);
				
			}

			
		}

		
	
	}

	

	
	
	
}