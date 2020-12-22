package com.example.extraclasedatos

import AATree
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

/**
 * Clase principal donde se definen los diferentes elementos de la pantalla principal de la aplicación que
 * muestra una forma sencilla de agregar elementos a un árbol AA, los elementos son:
 *el área de texto donde se ingresa el numero
 * el botón para registrar el numero
 * 3 áreas de texto para mostrar los recorridos en inorden, preorden y post orden de un árbol AA
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val numberText = findViewById<EditText>(R.id.numberInput)
        val numberButton = findViewById<Button>(R.id.numberButton)
        val deleteButton = findViewById<Button>(R.id.deleteNodes)

        val myAATree = AATree()
        val preOrder = findViewById<TextView>(R.id.preOrder)
        val inOrder = findViewById<TextView>(R.id.inOrder)
        val postOrder = findViewById<TextView>(R.id.postOrder)

        numberButton.setOnClickListener {
            val numberIn = numberText.text.toString().toInt()
            myAATree.insert(numberIn)
            printPreorder(preOrder, myAATree)
            printInorder(inOrder, myAATree)
            printPostorder(postOrder, myAATree)
        }
        deleteButton.setOnClickListener {
            preOrder.text = ""
            inOrder.text = ""
            postOrder.text = ""
            myAATree.clear()
        }

    }

    /**
     * Función para imprimir en pantalla el preorden del árbol actual
     */
    private fun printPreorder(textArea: TextView, myTree : AATree){
        myTree.preorder()
        textArea.text = myTree.getCurrentPreorder()
    }
    /**
     * Función para imprimir en pantalla el inorden del árbol actual
     */
    private fun printInorder(textArea: TextView, myTree : AATree){
        myTree.inorder()
        textArea.text = myTree.getCurrentInorder()
    }
    /**
     * Función para imprimir en pantalla el postorden del árbol actual
     */
    private fun printPostorder(textArea: TextView, myTree : AATree){
        myTree.postorder()
        textArea.text = myTree.getCurrentPostOrder()
    }
}