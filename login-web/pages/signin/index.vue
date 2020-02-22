<template>
  <v-content>
    <v-container fluid>
      <v-row
        align="center"
        justify="center"
      >
        <v-col cols="3">
          <v-stepper v-model="e1">
            <v-stepper-items>
              <v-stepper-content step="1">
                <v-card>
                  <v-card-text>
                    <p class="text--primary">
                      <strong>로그인</strong>
                    </p>
                    <v-row>
                      <v-col>
                        <v-form
                          ref="emailForm"
                          v-model="valid"
                          :lazy-validation="lazy"
                        >
                          <email-field v-model="email" />
                          <v-btn
                            text 
                            color="primary"
                            height="30"
                            class="pa-0"
                            to="/"
                          >
                            이메일을 잊으셨나요?
                          </v-btn>
                        </v-form>
                      </v-col>
                    </v-row>
                  </v-card-text>
                  <v-card-actions>
                    <v-btn
                      text
                      color="primary"
                      left
                      to="/signup"
                    >
                      계정 만들기
                    </v-btn>
                    <v-spacer />
              
                    <v-btn
                      color="primary"
                      @click="emailValidate"
                    >
                      다음
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-stepper-content>
              <v-stepper-content step="2">
                <v-card>
                  <v-card-text>
                    <p class="text--primary">
                      시작하기
                    </p>
                    <v-chip
                      class="ma-2"
                      color="primary"
                      outlined
                      pill
                      @click="resetEmail"
                    >
                      <v-icon left>
                        mdi-account-outline
                      </v-icon>
                      {{ email }}
                    </v-chip>
                    <v-row>
                      <v-col>
                        <v-form
                          ref="passwordForm"
                          v-model="valid"
                          :lazy-validation="lazy"
                        >
                          <password-field v-model="password" />
                          <v-btn
                            text 
                            color="primary"
                            height="30"
                            class="pa-0"
                            to="/"
                          >
                            비밀번호를 잊으셨나요?
                          </v-btn>
                        </v-form>
                      </v-col>
                    </v-row>
                  </v-card-text>
                  <v-card-actions>
                    <v-spacer />
                    <v-btn
                      color="primary"
                      @click="validate"
                    >
                      다음
                    </v-btn>
                  </v-card-actions>
                </v-card>
              </v-stepper-content>
            </v-stepper-items>
          </v-stepper>
        </v-col>
      </v-row>
    </v-container>
  </v-content>
</template>

<script>
import emailField from "~/components/signin/email-field.vue"
import passwordField from "~/components/signin/password-field.vue"
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
            loading:false,
            e1: 1,
        }
    },
    methods: {

      validate () {
            if (this.$refs.passwordForm.validate()) {
              this.snackbar = true
              this.$axios.post('/api/signin/session',{
                  email : this.email,
                  password : this.password,
              })
              .then((res) => {
                  console.log(res)
              })
              .catch((error) => {
                  console.error(error)
              })
            }
      },
      emailValidate(){
        if (this.$refs.emailForm.validate()) {
              this.$axios.post('/api/signin/lookup',{
                  email : this.email
              })
              .then((res) => {
                  this.e1 = 2
                  console.log(res)
              })
              .catch((error) => {
                  this.e1 = 2
                  console.error(error)
              })
        }
      },
      resetEmail(){
        this.e1 = 1
      }
    },
  }
</script>