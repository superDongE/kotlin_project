package com.example.soomgo.searchgosuRegin

internal object ExpandableListData {
    val data: HashMap<String, List<String>>
        get() {
            val expandableListDetail =
                HashMap<String, List<String>>()


            val myFavCricketPlayers: MutableList<String> =
                ArrayList()
            //서울
            myFavCricketPlayers.add("강남구")
            myFavCricketPlayers.add("강동구")
            myFavCricketPlayers.add("강북구")
            myFavCricketPlayers.add("강서구")
            myFavCricketPlayers.add("관악구")
            myFavCricketPlayers.add("광진구")
            myFavCricketPlayers.add("구로구")
            myFavCricketPlayers.add("금천구")
            myFavCricketPlayers.add("노원구")
            myFavCricketPlayers.add("도봉구")
            myFavCricketPlayers.add("동대문구")
            myFavCricketPlayers.add("동작구")
            myFavCricketPlayers.add("마포구")
            myFavCricketPlayers.add("서대문구")
            myFavCricketPlayers.add("서초구")
            myFavCricketPlayers.add("성동구")
            myFavCricketPlayers.add("성북구")
            myFavCricketPlayers.add("송파구")
            myFavCricketPlayers.add("양천구")
            myFavCricketPlayers.add("영등포구")
            myFavCricketPlayers.add("용산구")
            myFavCricketPlayers.add("은평구")
            myFavCricketPlayers.add("종로구")
            myFavCricketPlayers.add("중구")
            myFavCricketPlayers.add("중구")





            // 부산
            val myFavFootballPlayers: MutableList<String> = ArrayList()

            myFavFootballPlayers.add("강서구")
            myFavFootballPlayers.add("금정구")
            myFavFootballPlayers.add("기장군")
            myFavFootballPlayers.add("남구")
            myFavFootballPlayers.add("동구")
            myFavFootballPlayers.add("동래구")
            myFavFootballPlayers.add("부산진구")
            myFavFootballPlayers.add("북구")
            myFavFootballPlayers.add("사상구")
            myFavFootballPlayers.add("사하구")
            myFavFootballPlayers.add("서구")
            myFavFootballPlayers.add("수영구")
            myFavFootballPlayers.add("연제구")
            myFavFootballPlayers.add("영도구")
            myFavFootballPlayers.add("중구")
            myFavFootballPlayers.add("해운대구")


            //대구
            val myFavTennisPlayers: MutableList<String> = ArrayList()


            val myFavIncheonPlayers: MutableList<String> = ArrayList()
            val myFavGawngPlayers: MutableList<String> = ArrayList()
            val myFavDaeJPlayers: MutableList<String> = ArrayList()
            val myFavUlsanPlayers: MutableList<String> = ArrayList()
            val myFavSejongPlayers: MutableList<String> = ArrayList()
            val myFavKungPlayers: MutableList<String> = ArrayList()
            val myFavKangWonPlayers: MutableList<String> = ArrayList()
            val myFavChungPlayers: MutableList<String> = ArrayList()
            val myFavNamPlayers: MutableList<String> = ArrayList()
            val myFavJenlaPlayers: MutableList<String> = ArrayList()
            val myFavNamdoPlayers: MutableList<String> = ArrayList()
            val myFavKungSangPlayers: MutableList<String> = ArrayList()
            val myFavKungdoPlayers: MutableList<String> = ArrayList()
            val myFavKekuPlayers: MutableList<String> = ArrayList()



            expandableListDetail["서울특별시"] = myFavCricketPlayers
            expandableListDetail["부산광역시"] = myFavFootballPlayers
            expandableListDetail["대구광역시"] = myFavTennisPlayers
            expandableListDetail["인천광역시"] = myFavIncheonPlayers
            expandableListDetail["광주광역시"] = myFavGawngPlayers
            expandableListDetail["대전광역시"] = myFavDaeJPlayers
            expandableListDetail["울산광역시"] = myFavUlsanPlayers
            expandableListDetail["세종특별자치시"] = myFavSejongPlayers
            expandableListDetail["경기도"] = myFavKungPlayers
            expandableListDetail["강원도"] = myFavKangWonPlayers
            expandableListDetail["충청북도"] = myFavChungPlayers
            expandableListDetail["충청남도"] = myFavNamPlayers
            expandableListDetail["전라북도"] = myFavJenlaPlayers
            expandableListDetail["전라남도"] = myFavNamdoPlayers
            expandableListDetail["경상북도"] = myFavKungSangPlayers
            expandableListDetail["경상남도"] = myFavKungdoPlayers
            expandableListDetail["제주특별자치도"] = myFavKekuPlayers







            return expandableListDetail
        }
}