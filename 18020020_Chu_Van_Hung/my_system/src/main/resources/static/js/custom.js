//remove ajax
    $(document).ready(function () {
        $('.delete').click(function (e) {
            e.preventDefault();
            var getId = $(this).attr("name");
            //console.log("id = " + getId);
            $.ajax({
                url: '/delete',
                type: 'POST',
                dataType: 'html',
                data: {
                    id: getId
                },
            }).done(function (ketqua) {
                $('#list').html(ketqua);
            });

        });
    });

//search ajax
    $(document).ready(function () {
        $('#search').keyup(function (e) {
            e.preventDefault();
            var getName = $('#search').val();
            console.log(getName);
            $.ajax({
                url: '/search',
                type: 'POST',
                dataType: 'html',
                data: {
                    name: getName
                },
            }).done(function (ketqua) {
                $('#list').html(ketqua);
            });

        });
    });