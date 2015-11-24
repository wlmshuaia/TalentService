// JavaScript Document

function w()
{
	var wancheng=document.getElementById("wanchengpingjia");
	var wan=wancheng.getElementsByTagName("ul");
	var pp=[];
	var pj1=document.getElementById("pj1");
	var pj2=document.getElementById("pj2");
	var pj3=document.getElementById("pj3");
	
	for(var i=0;i<wan.length;i++)
	{
		wan[i].xingxing=wan[i].getElementsByTagName("li");
		pp[i]=0;
		wan[i].kk=i;
	}
	wancheng.kk=0;
	
	for(var j=0;j<5;j++)
	{
		wan[0].xingxing[j].index=j;
		wan[0].xingxing[j].kk=0;
		wan[1].xingxing[j].index=j;
		wan[1].xingxing[j].kk=0;
		wan[2].xingxing[j].index=j;
		wan[2].xingxing[j].kk=0;
	}
	
	for(var i=0;i<wan.length;i++)
	{
		wan[i].onmouseout=function()
		{
			
			for(var j=0;j<5;j++)
			{
				if(this.xingxing[j].kk==1)
					this.xingxing[j].style.backgroundImage="url(./images/star1.png)";
				else
					this.xingxing[j].style.backgroundImage="url(./images/star2.png)";
			}
		}
		
		for(var j=0;j<5;j++)
		{
			wan[i].xingxing[j].onmouseover=function()
			{
				for(var x=0;x<5;x++)
				{
					if(this.parentNode.xingxing[x].kk==1)
						this.parentNode.xingxing[x].style.backgroundImage="url(./images/star1.png)";
					else if(x<=this.index)
						this.parentNode.xingxing[x].style.backgroundImage="url(./images/star1.png)";
					else
						this.parentNode.xingxing[x].style.backgroundImage="url(./images/star2.png)";
				}
				
			}
			wan[i].xingxing[j].onclick=function()
			{
				
				pp[this.parentNode.kk]=0;
				for(var x=0;x<5;x++)
				{
					if(x<=this.index)
					{
						this.parentNode.xingxing[x].kk=1;
						this.parentNode.xingxing[x].style.backgroundImage="url(./images/star1.png)";
					}
					else
					{
						this.parentNode.xingxing[x].kk=0;
						this.parentNode.xingxing[x].style.backgroundImage="url(./images/star2.png)";
					}
					
					if(this.parentNode.xingxing[x].kk==1)
					{
						pp[this.parentNode.kk]+=1;
					}
					
				}
				
				pj1.value=pp[0];
				pj2.value=pp[1];
				pj3.value=pp[2];
				
			}
		}
		
	}
	
}

