package com.dipartimento.demowebapplications.config.security;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JwtDecoderTest {


    @Test
    void decodeJwt(){
        String token="eyJhbGciOiJSUzI1NiIsImtpZCI6IjJjOGEyMGFmN2ZjOThmOTdmNDRiMTQyYjRkNWQwODg0ZWIwOTM3YzQiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiI0ODIwNTc4NTAyOC12M2I2ZHBtN3FtbDc3ajVoNWRpcm5sNDgwaGUwNWdtay5hcHBzLmdvb2dsZXVzZXJjb250ZW50LmNvbSIsImF1ZCI6IjQ4MjA1Nzg1MDI4LXYzYjZkcG03cW1sNzdqNWg1ZGlybmw0ODBoZTA1Z21rLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTA3MTA3NDc0Njc0MjcwODcyNjk3IiwiZW1haWwiOiJ1bmljYWx3ZWJhcHBsaWNhdGlvbjI0MjVAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsIm5iZiI6MTczMzc2Mjk2NSwibmFtZSI6Ik1hcmNvIFdBMjQyNSIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS9BQ2c4b2NJQUFHRkFDWmFLcF84dUVIcE94U0Z2Q295emd1WUZ0RUxqanZSNHpQZm9JRGs1eXc9czk2LWMiLCJnaXZlbl9uYW1lIjoiTWFyY28iLCJmYW1pbHlfbmFtZSI6IldBMjQyNSIsImlhdCI6MTczMzc2MzI2NSwiZXhwIjoxNzMzNzY2ODY1LCJqdGkiOiI2NGU4MjEzYjFhOTY1ZWIzOGVlNmRiMTAxMjBiZjU3M2U0ZGM1NDdiIn0.njCJ8bpkolAZgB0sC-GW-H7X2SspCfjj1SMCnoUGZyJ4OgeOBe7kuKQh2boTel5VvEcQdv__kTvUxlJsClZ7pOp14wbNe259mbKERvjFe-US4nOXQVMryyaHwp15zBEiVi6Nqa7rCe-jJPCSoIOA9kFV0_Wz4TEL3FRGHPJDJTlqLdhklKN7Q-BtifipgxQ5AJpc0dV16UteilNjQYLdsDnP9osAR4Uen7cA8hGTuDZNds02bENXWoQ8PlvKpDTaOJsowrexsrUMWmSLYn67SG3rEgXygJXJnQ2CcFeRS9KGlkysIGJkQg1918Iu0lC0hTA0HYk-ZCJKXyabsDI68w";
        Map<String, Object> stringObjectMap = JwtDecoder.decodeJWT(token);

        for (String k : stringObjectMap.keySet()) {
            System.out.println(k + ": " + stringObjectMap.get(k));
        }

    }



}
