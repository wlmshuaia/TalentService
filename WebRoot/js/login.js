// JavaScript Document
function c()
{
	var id=document.getElementById("idname");
	var pw=document.getElementById("passwd");
	
	var i=0,j=0;
	

	id.onclick=function(ev)
	{
		var oEvent=ev||event;
		oEvent.cancelBubble=true;
		if(true)
		{
			id.style.background="#b3d5dd";
		}
		if(pw.value=="")
		{
			pw.style.background="url(./images/mima_1.gif)";
		}
		
	};
	
	pw.onclick=function(ev)
	{
		var oEvent=ev||event;
		oEvent.cancelBubble=true;
		if(true)
		{
			pw.style.background="#406272";
			pw.type="password";
			
		}
		if(id.value=="")
		{
			id.style.background="url(./images/yonghuming_1.gif)";
		}


	};

	pw.oninput=function()
	{
		if(pw.value=="")
		{
			pw.style.background="url(./images/mima_1.gif)";
			
		}
		else
		{
			pw.type="password";
		}
	}
	
		
		
	
	
	
	
	
	document.onclick=function()
	{

		if(id.value=="")
		{
			id.style.background="url(../images/yonghuming_1.gif)";
		}
		
		if(pw.value=="")
		{
			pw.style.background="url(../images/mima_1.gif)";
		}
		
			
	}
	
}
