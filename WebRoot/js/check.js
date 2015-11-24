// JavaScript Document
function j()
{
	var xuan=document.getElementById("d1");
	var cb=xuan.getElementsByTagName("input");
	var d2=document.getElementById("d2");
	var d3=d2.getElementsByTagName("div");
	
	for(var i=0;i<cb.length;i++)
	{
		cb[i].l=0;
	}
	
	
	for(var i=0;i<cb.length;i++)
	{
		cb[i].onclick=function()
		{
			
			if(this.l==0)
			{
				this.checked=true;
				this.l=1;
			}
			else
			{
				this.checked=false;
				this.l=0;
			}
			
			
			
			
			for(var kk=0;kk<d3.length;kk++)
			{
				if(cb[kk].l==1)
				{
					d3[kk].style.display="block";
				}
				else
				{
					d3[kk].style.display="none";
				}
			}
		}
		
		
		
		
	}
	
	
	
	
	
}
