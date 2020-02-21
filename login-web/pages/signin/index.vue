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
                로그인
              </p>
              <v-row>
                <v-col>
                  <v-form
                    ref="form"
                    v-model="valid"
                    :lazy-validation="lazy"
                  >
                    <v-text-field
                      v-model="email"
                      :rules="emailRules"
                      label="e-mail"
                      required
                      outlined
                      focus
                    />
                    <v-text-field
                      v-model="password"
                      :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
                      :rules="passwordRules"
                      :type="show ? 'text' : 'password'"
                      name="input-10-1"
                      label="password"
                      hint="8글자이상 12자 이하"
                      counter
                      @click:append="show = !show"
                    />
                  </v-form>
                </v-col>
              </v-row>
            </v-card-text>
            <v-card-actions>
              <v-spacer />
              <v-btn
                text
                color="primary"
                left
              >
                게정 만들기
              </v-btn>
              <v-btn
                color="primary"
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
  export default {
    layout: 'disabledHeader',
    data (){
        return {
            show: false,
            password: '',
            passwordRules: [
                v => !!v || '비밀번호를 입력하세요',
                v => (v && v.length <= 12) || '비밀번호는 12자리 이하 입니다.',
                v => (v && v.length >= 8) || '비밀번호는 8자리 이상 입니다.',
            ],
            email: '',
            emailRules: [
                v => !!v || '이메일을 입력하세요',
                v => /.+@.+\..+/.test(v) || '이메일 형식이 잘못되었습니다.',
            ],
            lazy: false,
            alignment: 'center',
            justify: 'cneter'
        }
    },
    methods: {

      validate () {
            if (this.$refs.form.validate()) {
            this.snackbar = true
            }
            this.$axios.post('/api/login/session',{
                email : this.email,
                password : this.password,
            })
            .then((res) => {
                console.log(res)
            })
            .catch((error) => {
                console.error(error)
            })
            
        },
      reset () {
        this.$refs.form.reset()
      },
      
    },
  }
</script>