// JavaScript Document

function h()
{
	var fahuati=document.getElementById("fahuati");
	fahuati.onclick=function()
	{
		if(document.body)
		{
			document.body.scrollTop=document.body.offsetHeight-document.documentElement.clientHeight;
			
		}
		if(document.documentElement)
		{
			document.documentElement.scrollTop=document.body.offsetHeight-document.documentElement.clientHeight;
			
		}
	}
}