$(function() {
	$("div[name=cp]").hide();
	$("div[name=check]").hide();
	$("img[name=cp]").click(function() {
		$("div[name=cp]").hide();
		$("div[name=check]").hide();
		$("div[name=cp]").show();
	})
	$("img[name=check]").click(function() {
		$("div[name=cp]").hide();
		$("div[name=check]").hide();
		$("div[name=check]").show();
	})
})