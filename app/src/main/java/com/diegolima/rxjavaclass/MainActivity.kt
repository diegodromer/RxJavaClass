package com.diegolima.rxjavaclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*createFromArra().subscribe{ arr -> println("received array is: " + Arrays.toString(arr)) }*/
/*        createFromIterable().subscribe{a -> println("received data is: $a") }*/
        /*createRange().subscribe { a -> println("received data is: $a") }*/
        /*createInterval().subscribe { a -> println("received data is: $a") }*/
        /*createTimer().subscribe { a -> println("The food is ready after: $a") }*/
//        createFilter().subscribe { a -> println("The data received is: $a") }
//        createTakeLast().subscribe { a -> println("The data received is: $a") }
        //createTake().subscribe { a -> println("The data received is: $a") }

/*        createTimeOut("reem").subscribe({
                //quando no próximo método
                name -> println("Hello $name")
            },{
                //quando o erro é chamado
                throwble -> println("You have an error in : " + throwble.javaClass.simpleName)
            }
        )*/

/*        createDistinct().subscribe({
                //quando no próximo método
                value -> println("value is $value")
            },{
                //quando o erro é chamado
                throwble -> println("You have an error in : " + throwble.javaClass.simpleName)
            }
        )*/

        /*createStartWith().subscribe({
            //quando no próximo método
                value ->
            println("name is $value")
        }, {
            //quando o erro é chamado
                throwble ->
            println("You have an error in : " + throwble.javaClass.simpleName)
        })*/

/*        createMerge().subscribe({
            //quando no próximo método
                value ->
            println("value is $value")
        }, {
            //quando o erro é chamado
                throwble ->
            println("You have an error in : " + throwble.javaClass.simpleName)
        })*/

/*        createConcat().subscribe({
            //quando no próximo método
                value ->
            println("value is $value")
        }, {
            //quando o erro é chamado
                throwble ->
            println("You have an error in : " + throwble.javaClass.simpleName)
        })*/

/*        createZip().subscribe({
            //quando no próximo método
                value ->
            println("value is $value")
        }, {
            //quando o erro é chamado
                throwble ->
            println("You have an error in : " + throwble.javaClass.simpleName)
        })*/

/*        createMap().subscribe({
            //quando no próximo método
                value ->
            println("value is $value")
        }, {
            //quando o erro é chamado
                throwble ->
            println("You have an error in : " + throwble.javaClass.simpleName)
        })*/

/*        createFlatMap().subscribe({
            //quando no próximo método
                name ->
            println("name is $name")
        }, {
            //quando o erro é chamado
                throwble ->
            println("You have an error in : " + throwble.javaClass.simpleName)
        })*/

/*        val professor = PublishSubject.create<String>()

        professor.subscribe(getFirstStudent())
        professor.onNext("kotlin")
        professor.onNext("java")
        professor.onNext("C++")

        professor.subscribe(getLateStudent())

        professor.onNext("scala")
        professor.onComplete()*/

/*        //replay Objects
        val professor = ReplaySubject.create<String>()

        professor.subscribe(getFirstStudent())
        professor.onNext("Kotlin")
        professor.onNext("Java")
        professor.onNext("C++")

        professor.subscribe(getLateStudent())
        professor.onNext("scala")

        professor.onComplete()*/

/*        //Behavior
        val professor = BehaviorSubject.create<String>()

        professor.subscribe(getFirstStudent())
        professor.onNext("Kotlin")
        professor.onNext("Java")
        professor.onNext("C++")

        professor.subscribe(getLateStudent())
        professor.onNext("scala")

        professor.onComplete()*/

        /*val professor = AsyncSubject.create<String>()

        professor.subscribe(getFirstStudent())
        professor.onNext("Kotlin")
        professor.onNext("Java")
        professor.onNext("C++")

        professor.subscribe(getLateStudent())
        professor.onNext("scala")

        professor.onComplete()*/

        myGithubStarsRepos.setOnClickListener {
            startActivity(Intent(applicationContext, MyStarsRepos::class.java))
        }

    }

    private fun showJustJob() {

        val dataStream = Observable.just(10, 20, 30, 40)

        val dataObservable = object : Observer<Int> {
            override fun onComplete() {
                println("All data is received.....")
            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(t: Int?) {
                println("new data is received : $t")
            }

            override fun onError(e: Throwable?) {
                println("An ERROR is received" + e?.message)
            }
        }
        dataStream.subscribe(dataObservable)
    }

    private fun createFromArra(): Observable<Array<Int>> {
        return Observable.fromArray(arrayOf(1, 5, 7, 9))
    }

    private fun createFromIterable(): Observable<Int> {
        return Observable.fromIterable(mutableListOf(2, 5, 7))
    }

    private fun createRange(): Observable<Int> {
        return Observable.range(1, 3).repeat(3)
    }

    private fun createInterval(): Observable<Long> {
        return Observable.interval(1, TimeUnit.SECONDS).takeWhile { value ->
            value < 20

        }
    }

    private fun createTimer(): Observable<Long> { //imprime depois de 5 segundos no console (terminal)
        return Observable.timer(5, TimeUnit.SECONDS)
    }

    private fun createFilter(): Observable<Int> {
        return Observable.just(2, 40, 30, 5)
            .filter { x -> x > 10 }
    }

    private fun createTakeLast(): Observable<Int> {
        return Observable.just(2, 40, 30, 5)
            .takeLast(2)
    }

    private fun createTake(): Observable<Int> {
        return Observable.just(2, 40, 30, 5)
            .take(2)
    }

    private fun createTimeOut(name: String): Observable<String> {
        return Observable.fromCallable {
            if (name.equals("ramadan")) {
                Thread.sleep(150)
            }
            name
        }.timeout(100, TimeUnit.MILLISECONDS)
    }

    private fun createDistinct(): Observable<Int> {
        return Observable.just(1, 2, 2, 2, 4, 5, 5)
            .distinct()
    }

    private fun createStartWith(): Observable<String> {
        return Observable.just("ramadan", "mohamed", "Ahmed").startWithItem("Reem")
    }

    private fun createMerge(): Observable<Int> {
        val firstStream = Observable.just(1, 2, 3)
        val secondStream = Observable.just(4, 5, 6)

        return firstStream.mergeWith(secondStream)
    }

    private fun createConcat(): Observable<Int> {
        val firstStream = Observable.just(1, 2, 3)
        val secondStream = Observable.just(4, 5, 6)

        return firstStream.concatWith(secondStream)
    }

    private fun createZip(): Observable<String> {
        val firstNames = Observable.just("Mohamed", "Ahmed", "Mahamoud")
        val lastNames = Observable.just("radadan", "yousulf", "Omar")

        return firstNames.zipWith(lastNames, { first, last ->
            "$first $last"
        })
    }

    private fun createMap(): Observable<Int> {
        return Observable.just(1, 2, 3, 4, 5)
            .map { value -> value * 10 }
    }

    private fun createFlatMap(): Observable<String> {
        return Observable.just("x0111111", "x987878787", "yt5656565656")
            .flatMap { _ ->
                getName()
            }
    }

    private fun getName(): Observable<String> {
        val names = arrayOf("ramadan", "hashem", "Yousef")
        val rand = Random().nextInt(3)

        return Observable.just(names[rand])
    }

    private fun getFirstStudent(): Observer<String>{

        return object :Observer<String>{
            override fun onComplete() {
                println("a palestra acabou - first")
            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(t: String?) {
                println("primeiro aluno -> nosso professor nos ensina sobre $t")
            }

            override fun onError(e: Throwable?) {
                println("error")
            }
        }
    }

    private fun getLateStudent(): Observer<String>{

        return object :Observer<String>{
            override fun onComplete() {
                println("a palestra acabou - late")
            }

            override fun onSubscribe(d: Disposable?) {
            }

            override fun onNext(t: String?) {
                println("estudante atrasado -> nosso professor nos ensina sobre $t")
            }

            override fun onError(e: Throwable?) {
                println("error")
            }
        }
    }
}
