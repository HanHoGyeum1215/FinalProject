(function($) {

    $( "#uBirthStr" ).datepicker({
        dateFormat: "yy - mm - dd",
        showOn: "both",
        buttonText : '<i class="zmdi zmdi-calendar-alt"></i>',
    });

    $('.add-info-link ').on('click', function() {
        $('.add_info').toggle( "slow" );
    });


    $('#signup-form').validate({
        rules : {
            id : {
                required: true,
            },
            name : {
                required: true,
            },
            uEmail : {
                required: true,
            },
            uEmail2 : {
                required: true,
            },
            phone_number : {
                required: true
            },
            password : {
                required: true
            },
            re_password : {
                required: true,
                equalTo: "#password"
            }
        },
        onfocusout: function(element) {
            $(element).valid();
        },
    });

    jQuery.extend(jQuery.validator.messages, {
        required: "",
        remote: "",
        uEmail: "",
        url: "",
        uEmail2: "",
        date: "",
        dateISO: "",
        number: "",
        digits: "",
        creditcard: "",
        equalTo: ""
    });
})(jQuery);
