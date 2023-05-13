package com.example.saifapp

data class Actor(val imageActorId: Int, val nameActor: String, val titleActor: String)
class ActorList {val list2 = arrayListOf(
    Actor(R.drawable.`a1`, "Майкл Дж. Фокс", "Марти Макфлай"),
    Actor(R.drawable.a2, "Кристофер Ллойд", "Доктор Эмметт Браун"),
    Actor(R.drawable.a3, "Лиа Томпсон","Лоррейн Бейнс"),
    Actor(R.drawable.a4, "Криспин Гловер","Джордж МакФлай"),
    Actor(R.drawable.a5, "Томас Ф. Уилсон","Бифф Таннен"))}