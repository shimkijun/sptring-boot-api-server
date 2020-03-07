<template>
  <v-content>
    <v-container fluid>
      <v-row
        align="center"
        justify="center"
      >
        <v-col cols="3">
          <v-card>
            <v-card-text>
              <p class="text--primary">
                <strong>계정 만들기</strong>
              </p>
              <v-row>
                <v-col>
                  <v-form
                    ref="siginupForm"
                    v-model="valid"
                    :lazy-validation="lazy"
                  >
                    <email-field v-model="email" />
                    <nickname-field v-model="nickname" />
                    <password-field v-model="password" />
                    <password-field v-model="reconfirmPassword" />
                  </v-form>
                </v-col>
              </v-row>
            </v-card-text>
            <v-card-actions>
              <v-btn
                text
                color="primary"
                left
                to="/signin"
              >
                로그인 하기
              </v-btn>
              <v-spacer />
              
              <v-btn
                color="primary"
                @click="validate"
              >
                다음
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-content>
</template>

<script>
import emailField from "~/components/user-form/email-field.vue"
import passwordField from "~/components/user-form/password-field.vue"
import nicknameField from "~/components/user-form/nickname-field.vue"

  export default {
    layout: 'disabledHeader',
    components:{
      emailField,
      passwordField,
      nicknameField
    },
    data (){
        return {
            lazy: false,
            valid:false,
            alignment: 'center',
            justify: 'cneter',
            email:'',
            password:'',
            nickname:'',
            reconfirmPassword:'',
            loading:false,
        }
    },
    methods: {
        validate () {

            if(this.password !== this.reconfirmPassword){
                this.valid = false
                return
            }

            if (this.$refs.siginupForm.validate()) {
                this.snackbar = true
                this.$axios.post('/api/user',{
                    email : this.email,
                    nickname : this.nickname,
                    password : this.password
              })
              .then((res) => {
                  console.log(res)
              })
              .catch((error) => {
                  console.error(error)
              })
            }
        },
    },
  }
</script>