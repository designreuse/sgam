
$(document).ready(function(){
	$('#dataNascimento .input-group.date').datepicker({
		format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true
    });
});