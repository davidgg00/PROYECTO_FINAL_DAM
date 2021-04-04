<?php

class ConexionBD
{

    private $conn;

    function __construct()
    {
        $this->conn = null;
    }

    function abrirConexion()
    {
        $datos = 'mysql:host=' . DB_HOST . ';dbname='
            . DB_NAME;
        try {
            $this->conn = new PDO(
                $datos,
                DB_USER,
                DB_PASSWORD
            );
        } catch (PDOException $e) {
            echo 'Error conexion' . $e->getMessage();
        }
        return $this->conn;
    }

    function consultaSeleccion($sql)
    {
        $conexion = $this->abrirConexion();

        $consulta = $conexion->query($sql);

        $filas = array();

        while ($fila = $consulta->fetch(PDO::FETCH_OBJ)) {
            $filas[] = $fila;
            //array_push($filas,$fila);          
        }

        $this->cerrarConexion();
        return $filas;
    }

    function consultaSeleccionParam($sql, $parametros)
    {
        $resultado = false;
        $conexion = $this->abrirConexion();

        $consulta = $conexion->prepare($sql);
        $consulta->execute($parametros);
        $filas = array();
        while ($fila = $consulta->fetch(PDO::FETCH_OBJ)) {
            $filas[] = $fila;
            //array_push($filas,$fila);          
        }

        $this->cerrarConexion();
        return $filas;
    }

    function consultaManipulacion($sql, $parametros)
    {
        $conexion = $this->abrirConexion();
        if (isset($parametros)) {
            $sentencia = $conexion->prepare($sql);
            $sentencia->execute($parametros);
            $this->cerrarConexion();
            return $sentencia->rowCount();
        }
    }

    /**
     * Método añadido para que me retorne el ultimo id insertado
     */
    function consultaManipulacion_retornalastID($sql, $parametros)
    {
        $resultado = false;
        $conexion = $this->abrirConexion();

        $sentencia = $conexion->prepare($sql);

        if ($sentencia) {
            $resultado = $sentencia->execute($parametros);
        }
        $this->cerrarConexion();
        return $conexion->lastInsertId();
    }

    /**
     * Método añadido para que me retorne un campo despues de insertar o hacer update
     */
    function consultaManipulacion_retornarFila($sql, $parametros)
    {
        $resultado = false;
        $conexion = $this->abrirConexion();

        $sentencia = $conexion->prepare($sql);

        if ($sentencia) {
            $resultado = $sentencia->execute($parametros);
            $id = $conexion->lastInsertId();
            $stmt = $conexion->prepare("SELECT * FROM pedidos WHERE id=?");
            $stmt->execute([$id]);
            $lastrow = $stmt->fetchObject();
            return $lastrow;
        }

        $this->cerrarConexion();
    }

    function cerrarConexion()
    {
        $this->conn = null;
    }

    function getLastId()
    {
        $datos = 'mysql:host=' . DB_HOST . ';dbname='
            . DB_NAME;
        $this->conn = new PDO(
            $datos,
            DB_USER,
            DB_PASSWORD
        );
        return $this->conn->lastInsertId();
    }
}
