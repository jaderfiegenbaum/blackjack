<?php
    $conexao = pg_connect("host=127.0.0.1 user=postgres port=5432 dbname=jackblack") or die('connection failed');;

    /**
     * Inserir registro.
     *
     * @param $valores Valores do vindos por GET.
     * @return boolean Retorna verdadeiro caso tenha inserido com sucesso.
     */
    function inserir($conexao, $nome, $pontuacao)
    {
        $ok = pg_exec($conexao, $sql = "INSERT INTO ranking VALUES (default, '{$nome}', $pontuacao);");
        
        return $ok;
    }
    
    /**
     * Listar registros.
     */
    function listar($conexao)
    {
        $resultado = pg_query($conexao, "SELECT nome, pontos FROM ranking ORDER BY pontos DESC");
        
        $retorno = array();
        
        while ( $linha = pg_fetch_array($resultado, NULL, PGSQL_ASSOC) )
        {
            $retorno[] = (object) $linha;
        }
        
        return $retorno;
    }
    
    $nome = $_GET['nome'];
    $pontuacao = $_GET['pontuacao'];

    // Verifica se é necessário realizar a insersão.
    if ( strlen($nome) )
    {
        // Insere registro.
        $ok = inserir($conexao, $nome, $pontuacao);
    }
    
    // Lista os todos os rankings.
    $listagem = listar($conexao);

?>
<html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <center>
        <table>
            <td width="258">
            <a href=""><img src="banner3.png" border="0" title="	"></a>
            </td>
        </table>
    	</center>
   <head>
      <link rel="stylesheet" href="estilo.css">
   </head>
   <body>
        <center>
        <table id = "resultado">
            <tr>
                <th align="center"><center><font size = 6>Posição</font></center></th>
                <th align="center"><center><font size = 6>Nome</font></center></th>
                <th align="center"><center><font size = 6>R$</font></center></th>
            </tr>
            <?php
                $contador = 1;
                foreach ( $listagem as $i => $linha )
                {
                    echo "<tr>";
                    echo "<th><center>" . $contador++ . "º</center></th>";
                    echo "<th>" . $linha->nome . "</th>";
                    echo "<th>" . $linha->pontos . ",00</th>";
                    echo "</tr>";
                }
            ?>
        </table>
        </center>
    </body>
    </html>
