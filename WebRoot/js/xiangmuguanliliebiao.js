// JavaScript Document

function q()
{
	var xiangmuguanliliebiao=document.getElementById("xiangmuguanliliebiao");
	var xiangmuguanli=xiangmuguanliliebiao.getElementsByTagName("li");
	
	var chakan=document.getElementsByClassName("chakanxianyoujingbiaofangan");
	var yige=document.getElementsByClassName("yige");
	for(var i=0;i<xiangmuguanli.length;i++)
	{
		xiangmuguanli[i].style.cursor="pointer";
		xiangmuguanli[i].onmouseover=function()
		{
			this.style.color="#ff6900";
			this.style.borderBottom="3px #ff6900 solid";
		}
		xiangmuguanli[i].onmouseout=function()
		{
			this.style.color="#000";
			this.style.borderBottom="3px #e7f1f3 solid";
		}
	}
	for(var i=0;i<chakan.length;i++)
		chakan[i].index=i;
	
	
	for(var i=0;i<chakan.length;i++)
	{	
		chakan[i].onclick=function()
		{
			if(yige[this.index].style.display=="none")
			{
				yige[this.index].style.display="block";
				this.innerHTML="收起";
			}
			else
			{
				yige[this.index].style.display="none";	
				this.innerHTML="查看现有竞标方案";
			}
		}
	}
	
}