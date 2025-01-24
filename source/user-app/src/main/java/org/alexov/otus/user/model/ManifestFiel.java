package org.alexov.otus.user.model;

public class ManifestFiel {
    public static final String MANIFEST = """
              getUserByLogin:
                type: restful
                get:
                  tags:
                    - user
                  summary: Получить данные пользователя по логину
                  description: ''
                  operationId: getUserByLogin
                  parameters:
                    - name: login
                      in: path
                      description: 'The name that needs to be fetched. Use user1 for testing. '
                      required: true
                      schema:
                        type: string
                  responses:
                    '200':
                      description: successful operation
                      content:
                        application/json:
                          schema:
                            $ref: '#/components/schemas/User'
                    '400':
                      description: Invalid username supplied
                    '404':
                      description: User not found
            """;
}
