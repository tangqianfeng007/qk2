$(function () {
    $(".slide1").click(function () {
            $(".slideShow1").slideToggle("slow")
        },
        function () {
            $(".slideShow2").slideToggle("slow")
        });
})
