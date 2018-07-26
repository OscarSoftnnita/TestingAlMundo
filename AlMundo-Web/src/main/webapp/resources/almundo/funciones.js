/*
 * @author. Yaher Carrillo
 * Permite ordenar los objetos creador por javascript de forma que se entienda lo mas ordenado posible
 * 
 */
ALMUNDO = {
    textosGlobal: [],
    firebase: '',
    self: '',
    config: '',
    pathclient: '',
    pathatenciones: '',
    urleventos: '',
    keyserver: '',
    //Metodos comunes
    LOGIN: {
        init: function () {
            self = this;
            console.log("Init Login Almundo");
            //Bloquea poder arrartrar objetos a los campos de trabajo
            ALMUNDO.COMMONS.block_dragAndDrop();
            //Bloquea el auto Completar de los campos de textos.
            ALMUNDO.COMMONS.block_autoComplete();
            //Valida los campos requeridos del formulario de login
            ALMUNDO.LOGIN.validateFieldsRequiredForms();
        },
        validateFieldsRequiredForms:function(){
            ALMUNDO.COMMONS.validateFieldEmpty($('#username'));
            ALMUNDO.COMMONS.validateFieldEmpty($('#password'));
        }
    },
    WELCOME: {
        init: function () {
            console.log("Init Welcome Almundo");
        }

    },
    PROFILE_USER: {
        init: function () {
            console.log("Init Welcome Almundo");
        }

    },
    COMMONS: {
        block_dragAndDrop: function () {
            $('img').on('mousedown', function (e) {
                e.preventDefault();
            });
            $('a').on('mousedown', function (e) {
                e.preventDefault();
            });
            $('input').on('drop', function (e) {
                e.preventDefault();
            });
        },
        block_autoComplete: function () {
            $('input').attr('autocomplete', 'off');
        },
        validateFieldEmpty: function (field) {
            field.blur(function() {
                var input=$(this);
                var is_name=input.val();
                if(is_name){
                    input.removeClass( "isoft_error_input" );
                }
                else{
                    input.addClass( "isoft_error_input" );
                }
            });
        }
    }

};