// JavaScript Document


k=function()
{
	
	var geren=document.getElementById("geren");
	var gerenxiaoxi=document.getElementById("gerenxiaoxi-container");
	var ii=document.getElementById("sousuo");
	var iu=document.getElementById("sousuoquanzi");
	
	geren.onmouseover=function()
	{
		this.style.cursor="pointer";
	}
	
	geren.onclick=function()
	{
		if(gerenxiaoxi.style.display=="none")
		{gerenxiaoxi.style.display="block";}
		else
		{gerenxiaoxi.style.display="none";}
	}

	ii.onclick=function(ev)
	{
		var oEvent=ev||event;
		oEvent.cancelBubble=true;
		if(true)
		{
			ii.style.background="#ffffff";
		}

		
	};
	
	
	
	

	iu.onclick=function(ev)
	{
		var oEvent=ev||event;
		oEvent.cancelBubble=true;
		if(true)
		{
			iu.style.background="#ffffff";
		}

		
	};
	
	
	document.onclick=function()
	{

		if(iu.value=="")
		{
			iu.style.background="url(../images/sousuoquanzi.gif)";
		}
		if(ii.value=="")
		{
			ii.style.background="url(../images/sousuo_2.gif)";
		}

		
			
	}	

		

	
	
	
	

}


