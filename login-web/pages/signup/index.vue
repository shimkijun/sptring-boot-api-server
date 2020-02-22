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
                    <emailField v-model="email" />
                    <passwordField v-model="password" />
                    <passwordField v-model="reconfirmPassword" />
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
import emailField from "~/components/signin/emailField.vue"
import passwordField from "~/components/signin/passwordField.vue"
  export default {
    layout: 'disabledHeader',
    components:{
      emailField,
      passwordField
    },
    data (){
        return {
            lazy: false,
            valid:false,
            alignment: 'center',
            justify: 'cneter',
            email:'',
            password:'',
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
                console.log('d')
              this.snackbar = true
              this.$axios.post('/api/customer/signup',{
                  email : this.email,
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