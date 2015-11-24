// JavaScript Document

function e()
{
	var shaixuan=document.getElementById("shaixuan");
	var shai=shaixuan.getElementsByTagName("li");
	var yixuan=document.getElementById("yixuan");
	var yi=yixuan.getElementsByTagName("li");	
	var yy=document.createElement("li");	
	var qw=[];
	var we=[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1];
	var qingkong=document.getElementById("qingkong");
	
	

	
	
	
	qingkong.onmouseover=function()
	{
		this.style.cursor="pointer";
		
	}
	
	
	
	
	
	
	
	qingkong.onclick=function()
	{
		for(var i=0;i<qw.length;i++)
		{
			yixuan.removeChild(qw[i]);

		}
		qw.length=0;
	}
	/*
	for(var i=0;i<qw.length;i++)
	{
		yixuan.removeChild(qw[i]);
		
	}
	*/
	
	
	for(var j=0;j<shai.length;j++)
	{
		shai[j].onmouseover=function()
		{
			this.style.cursor="pointer";
			
		}
		
		shai[j].onclick=function()
		{
			
			
				
			yy=this.cloneNode(true);
			yixuan.appendChild(yy);
			qw.push(yy);
			t();
		}
		
		
	}
	
	function t()
	{

		for(var i=0;i<qw.length;i++)
		{
			qw[i].onmouseovr=function()
			{
				this.style.cursor="pointer";
				
			}
			
			qw[i].onclick=function()
			{
				
				yixuan.removeChild(this);
				qw.pop(this);
				
			}
		}
	
	}
	
	
	
}



//#yixuan div{width:70px; height:27px; margin-left:20px; background-color:#FFF; border:1px solid #FFF; border-radius:4px;}