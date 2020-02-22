<template>
  <v-app>
    <v-content fluid>
      <v-container>
        <h1>{{ msg }}</h1>
        <div
          id="map"
          style="width:100%;height:100vh;"
        />
      </v-container>
    </v-content>
  </v-app>
</template>

<script>

  export default {
    data() {
      return {
        msg:"다음맵 테스트"
      }
    },
    mounted() {
        /* eslint-disable no-undef */
        let container = document.getElementById('map') //지도를 담을 영역의 DOM 레퍼런스
        let options = { //지도를 생성할 때 필요한 기본 옵션
          
          center: new kakao.maps.LatLng(37.36487189906812,127.23265705597912), //지도의 중심좌표.
          level: 10 //지도의 레벨(확대, 축소 정도)
        }
        let map = new kakao.maps.Map(container, options) //지도 생성 및 객체 리턴

        let clusterer = new kakao.maps.MarkerClusterer({
          map:map,
          averageCenter:true,
          minLevel:10
        })

        $.get("/data/maps.json", function(data) {
          let markers = $(data.positions).map(function(i, position) {
            return new kakao.maps.Marker({
                position : new kakao.maps.LatLng(position.lat, position.lng)
            });
          });

          // 클러스터러에 마커들을 추가합니다
          clusterer.addMarkers(markers);
      });
      
    },
    head:{
      script:[
        { src: "//dapi.kakao.com/v2/maps/sdk.js?appkey=0133dcaed0bd462fc689ea050efdfaa9&libraries=services,clusterer,drawing"},
        { src: 'https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'}
      ]
    }
  }
</script>