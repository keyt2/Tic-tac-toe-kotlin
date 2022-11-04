package tictactoe
import kotlin.math.abs
const val CELLS = 9

fun printBoard(board: MutableList<MutableList<Char>>) {
    println("----------")
    println("| ${board[0][0]} ${board[0][1]} ${board[0][2]} |")
    println("| ${board[1][0]} ${board[1][1]} ${board[1][2]} |")
    println("| ${board[2][0]} ${board[2][1]} ${board[2][2]} |")
    println("----------")
}

fun main(args: Array<String>) {
    var madeCorrectMove = false
    var input: String
    var move: MutableList<Char> = mutableListOf(' ', ' ')
    var Xwin = false
    var Owin = false
    var currentPlayer = 'X'
    var Xtotal = 0
    var Ototal = 0
    var Xline = 0
    var Oline = 0
    val board = mutableListOf(
        mutableListOf<Char>(' ', ' ', ' '),
        mutableListOf<Char>(' ', ' ', ' '),
        mutableListOf<Char>(' ', ' ', ' ')
    )
    printBoard(board)
    while (!Xwin && !Owin) {
        while(!madeCorrectMove) {
            var input = readln()
            input = input.replace(" ", "")
            move[0] = input[0]
            move[1] = input[1]
            if (move[0].digitToIntOrNull() == null || move[1].digitToIntOrNull() == null) {
                println("You should enter numbers!")
            }
            else if (!(move[0].digitToInt() in 1..3) || !(move[1].digitToInt() in 1..3)) {
                println("Coordinates should be from 1 to 3!")
            }
            else if (board[move[0].digitToInt() - 1][move[1].digitToInt() - 1] == 'O' || board[move[0].digitToInt() - 1][move[1].digitToInt() - 1] == 'X') {
                println("This cell is occupied! Choose another one!")
            }
            else {
                if (currentPlayer == 'X') {
                    board[move[0].digitToInt() - 1][move[1].digitToInt() - 1] = 'X'
                } else {
                    board[move[0].digitToInt() - 1][move[1].digitToInt() - 1] = 'O'
                }
                madeCorrectMove = true
            }
        }
        madeCorrectMove = false
        printBoard(board)
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == 'X') {
                    Xline++
                }
                else if (board[i][j] == 'O') {
                    Oline++
                }
            }
            if (Xline == 3) {
                Xwin = true
            }
            else if (Oline == 3) {
                Owin = true
            }
            Xtotal += Xline
            Ototal += Oline
            Xline = 0
            Oline = 0
        }
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[j][i] == 'X') {
                    Xline++
                }
                else if (board[j][i] == 'O') {
                    Oline++
                }
            }
            if (Xline == 3) {
                Xwin = true
            }
            else if (Oline == 3) {
                Owin = true
            }
            Xline = 0
            Oline = 0
        }
        for (i in 0..2) {
            if (board[i][i] == 'X') {
                Xline++
            }
            else if (board[i][i] == 'O') {
                Oline++
            }
        }
        if (Xline == 3) {
            Xwin = true
        }
        else if (Oline == 3) {
            Owin = true
        }
        Xline = 0
        Oline = 0
        for (i in 0..2) {
            if (board[i][2 - i] == 'X') {
                Xline++
            }
            else if (board[i][2 - i] == 'O') {
                Oline++
            }
        }
        if (Xline == 3) {
            Xwin = true
        }
        else if (Oline == 3) {
            Owin = true
        }
        if (Xtotal + Ototal == CELLS && !Xwin && !Owin) {
            println("Draw")
        }
        else if (Xwin) {
            println("X wins")
        }
        else if (Owin) {
            println("O wins")
        }
        Xline = 0
        Oline = 0
        if (currentPlayer == 'X') {
            currentPlayer = 'O'
        } else {
            currentPlayer = 'X'
        }
    }
}