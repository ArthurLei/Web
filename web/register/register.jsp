<%--
  Created by IntelliJ IDEA.
  User: 13696
  Date: 2019/12/11
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<!DOCTYPE html>
<!--[if IE 8 ]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9 ]> <html lang="en" class="ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>�û�ע��</title>


    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <![endif]-->
    <link href="css/normalize.css" rel="stylesheet"/>
    <link href="css/jquery-ui.css" rel="stylesheet"/>
    <link href="css/jquery.idealforms.min.css" rel="stylesheet" media="screen"/>
    <style type="text/css">
        body{font:normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;color: #222;background:url(pattern.png);overflow-y:scroll;padding:60px 0 0 0;}
        #my-form{width:755px;margin:0 auto;border:1px solid #ccc;padding:3em;border-radius:3px;box-shadow:0 0 2px rgba(0,0,0,.2);}
        #comments{width:350px;height:100px;}
    </style>
</head>
<body>

<div class="row">
    <div class="eightcol last">

        <!-- Begin Form -->

        <form id="my-form" action="${pageContext.request.contextPath}/servlet/user_register" method="post">
            <section name="��һ��">

                <div><label>�û���:</label><input id="username" name="username" type="text"/></div>
                <div><label>����:</label><input id="pass" name="password" type="password"/></div>
                <div><label>����:</label><input id="email" name="email" data-ideal="required email" type="email"/></div>
                <div><label>��������:</label><input name="date" class="datepicker" data-ideal="date" type="text" placeholder="��/��/��"/></div>
                <!--          <div><label>�ϴ�ͷ��:</label><input id="file" name="file" multiple type="file"/></div>-->
<%--                <div><label>������ҳ:</label><input name="website" data-ideal="url" type="text"/></div>--%>
            </section>
            <section name="�ڶ���">
                <div><label>�绰:</label><input  id="phone" name="phone" type="text"  >
                    <div><label>����:</label>
                        <select id="nation" name="nation">
                            <option value="default">&ndash; ѡ����� &ndash;</option>
                            <option value="AL">������</option>
                            <option value="AK">�й�</option>
                            <option value="AZ">����</option>
                            <option value="AR">����</option>
                            <option value="CA">Ӣ��</option>
                            <option value="CO">�¹�</option>
                            <option value="CT">������</option>
                            <option value="DE">����˹</option>
                        </select>
                    </div>
                    <!--        <div><label>�ʱ�:</label><input type="text" name="zip" data-ideal="zip"/></div>-->
                    <div><label>��ע:</label><textarea id="comments" name="remark"></textarea></div>
            </section>

            <div><hr/></div>

            <div>
                <button type="submit">�ύ</button>
                <button id="reset" type="button">����</button>
            </div>

        </form>

        <!-- End Form -->

    </div>

</div>


<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/jquery.idealforms.js"></script>
<script type="text/javascript">
    var options = {

        onFail: function(){
            alert( $myform.getInvalid().length +' invalid fields.' )
        },

        inputs: {
            'password': {
                filters: 'required pass',
            },
            'username': {
                filters: 'required username',
                data: {
                    //ajax: { url:'validate.php' }
                }
            },
            'file': {
                filters: 'extension',
                data: { extension: ['jpg'] }
            },
            'comments': {
                filters: 'min max',
                data: { min: 50, max: 200 }
            },
            'states': {
                filters: 'exclude',
                data: { exclude: ['default'] },
                errors : {
                    exclude: 'ѡ�����.'
                }
            },
            'langs[]': {
                filters: 'min max',
                data: { min: 2, max: 3 },
                errors: {
                    min: 'Check at least <strong>2</strong> options.',
                    max: 'No more than <strong>3</strong> options allowed.'
                }
            }
        }

    };

    var $myform = $('#my-form').idealforms(options).data('idealforms');

    $('#reset').click(function(){
        $myform.reset().fresh().focusFirst()
    });

    $myform.focusFirst();
</script>
</body>
</html>
