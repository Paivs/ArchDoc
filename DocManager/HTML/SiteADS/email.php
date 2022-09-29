<?php

$name = $_POST['name'];
$email = $_POST['email'];
$subject = $_POST['subject'];
$message = $_POST['message'];

$mailheader = "De: ".$name."<".$email.">\r\n";

$recipient = "archdocs.senai@gmail.com";

mail($recipient, $subject, $message, $mailheader) or die("Erro.");

echo'<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <title>Ajuda</title>
        <link rel="icon" href="logoArch.png" type="image">

        <body>
            <header>
                <div class="logo_site">
                    <a href="index.html" target="_blank">
                        <h1>
                            <img src="logoArch.png" title="logo" class="logo" width="100px" height="100px">
                        </h1>
                    </a>
                    <nav>
                        <ul>
                            <li><a href="index.html">Home</a></li>
                           <li><a href="ajuda.html">Ajuda</a></li>
                            <li><a href="CONTATO.html">Contato</a></li>
                        </ul>
                    </nav>
                </div>
            </header>
            <div class="container">              
               <h1>Obrigado por entrar em contato com a archDocs! Responderemos o mais rápido possível</h1>
                <p class="back">Volte para a <a href="index.html">página principal</a>.</p>
            </div>
            <script src="script.js"></script>
        </body>
    </head>
</html>';
?>