<template>
    <v-card outlined>
        <v-card-title>
            RequestDelivery
        </v-card-title>

        <v-card-text>
            <String label="LogisticsId" v-model="value.logisticsId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="requestDelivery"
            >
                RequestDelivery
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'RequestDeliveryCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.logisticsId = '';
        },
        watch: {
        },
        methods: {
            requestDelivery() {
                this.$emit('requestDelivery', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

